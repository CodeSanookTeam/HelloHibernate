/**
 * Created by TOSHIBA on Jul-17-15.
 */
class User2Tests extends GroovyTestCase {

    def void testPersonName() {
        def person = new User2([name: 'Aaron'])
        assert person.name == 'Aaron'
    }

    def void testPersonHello() {
        def person = new User2()
        assert person.hello() == 'รรรรรรร'
    }

    def void testBecauseOfYou() {
        def person = new User2()
        assert person.becauseOfYou() == 'เพราะยูเลย'
    }


}
