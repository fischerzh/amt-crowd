package amtcrowd



import org.junit.*
import grails.test.mixin.*

@TestFor(HITController)
@Mock(HIT)
class HITControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/HIT/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.HITInstanceList.size() == 0
        assert model.HITInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.HITInstance != null
    }

    void testSave() {
        controller.save()

        assert model.HITInstance != null
        assert view == '/HIT/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/HIT/show/1'
        assert controller.flash.message != null
        assert HIT.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/HIT/list'

        populateValidParams(params)
        def HIT = new HIT(params)

        assert HIT.save() != null

        params.id = HIT.id

        def model = controller.show()

        assert model.HITInstance == HIT
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/HIT/list'

        populateValidParams(params)
        def HIT = new HIT(params)

        assert HIT.save() != null

        params.id = HIT.id

        def model = controller.edit()

        assert model.HITInstance == HIT
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/HIT/list'

        response.reset()

        populateValidParams(params)
        def HIT = new HIT(params)

        assert HIT.save() != null

        // test invalid parameters in update
        params.id = HIT.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/HIT/edit"
        assert model.HITInstance != null

        HIT.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/HIT/show/$HIT.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        HIT.clearErrors()

        populateValidParams(params)
        params.id = HIT.id
        params.version = -1
        controller.update()

        assert view == "/HIT/edit"
        assert model.HITInstance != null
        assert model.HITInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/HIT/list'

        response.reset()

        populateValidParams(params)
        def HIT = new HIT(params)

        assert HIT.save() != null
        assert HIT.count() == 1

        params.id = HIT.id

        controller.delete()

        assert HIT.count() == 0
        assert HIT.get(HIT.id) == null
        assert response.redirectedUrl == '/HIT/list'
    }
}
