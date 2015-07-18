import model.User

class UserTests extends GroovyTestCase {

    def void testGetUserById() {

        def configuration = HibernateUtil.getConfiguration()
        def sessionFactory = HibernateUtil.getSessionFactory()

        def session = sessionFactory.openSession()
        def transaction = session.beginTransaction()

        def user = session.get(User.class,1);
        assert user.id == 1

        transaction.commit()
        session.close()
        println "user first name ${user.firstName}"
    }

}
