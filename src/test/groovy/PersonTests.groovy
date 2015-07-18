class PersonTests extends GroovyTestCase {

    def void testAddPerson() {

        def configuration = HibernateUtil.getConfiguration()
        def dbUsername = configuration.getProperty("hibernate.connection.username")
        def dbPassword = configuration.getProperty("hibernate.connection.password")
        assert dbUsername == "root"
        assert dbPassword == "your password"

        def sessionFactory = HibernateUtil.getSessionFactory()
        def person = new Person()
        person.setName("Sci")

        def session = sessionFactory.openSession()
        def transaction = session.beginTransaction()

        def query = session.createSQLQuery("TRUNCATE TABLE person;")
        query.executeUpdate()

        session.save(person)
        transaction.commit()
        session.close()

        assert person.id == 1
    }

}
