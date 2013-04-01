package amtcrowd



import org.junit.*
import grails.test.mixin.*

@TestFor(TasksController)
@Mock(Tasks)
class TasksControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tasks/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tasksInstanceList.size() == 0
        assert model.tasksInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tasksInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tasksInstance != null
        assert view == '/tasks/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tasks/show/1'
        assert controller.flash.message != null
        assert Tasks.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tasks/list'

        populateValidParams(params)
        def tasks = new Tasks(params)

        assert tasks.save() != null

        params.id = tasks.id

        def model = controller.show()

        assert model.tasksInstance == tasks
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tasks/list'

        populateValidParams(params)
        def tasks = new Tasks(params)

        assert tasks.save() != null

        params.id = tasks.id

        def model = controller.edit()

        assert model.tasksInstance == tasks
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tasks/list'

        response.reset()

        populateValidParams(params)
        def tasks = new Tasks(params)

        assert tasks.save() != null

        // test invalid parameters in update
        params.id = tasks.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tasks/edit"
        assert model.tasksInstance != null

        tasks.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tasks/show/$tasks.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tasks.clearErrors()

        populateValidParams(params)
        params.id = tasks.id
        params.version = -1
        controller.update()

        assert view == "/tasks/edit"
        assert model.tasksInstance != null
        assert model.tasksInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tasks/list'

        response.reset()

        populateValidParams(params)
        def tasks = new Tasks(params)

        assert tasks.save() != null
        assert Tasks.count() == 1

        params.id = tasks.id

        controller.delete()

        assert Tasks.count() == 0
        assert Tasks.get(tasks.id) == null
        assert response.redirectedUrl == '/tasks/list'
    }
}
