package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends MySQL implements PersonDAO {
    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null;  // non instantiated because if no records returned we dont want to use memory
        try {
            String sp = "{call GetPerson{?,?}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,10);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()){
                /*
                PersonId                index 1 INT
                FirstName               index 2 VARCHAR
                MiddleName              index 3 VARCHAR
                LastName                index 4 VARCHAR
                BirthDate               index 5 DATETIME
                SocialSecurityNumber    index 6 VARCHAR
                 */
                // notes: HYDRATING AN OBJECT
                person = new Person();
                person.setPersonId(rs.getInt(1));
                person.setFirstName(rs.getString(2));
                person.setMiddleName(rs.getString(3));
                person.setLastName(rs.getString(4));
                person.setBirthDate(rs.getDate(5));
                person.setSSN(rs.getString(6));

            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return person;
    }

    @Override
    public List<Person> getPersonList() {
        Connect();
        List<Person> personList = new ArrayList<Person>();
        try {
            String sp = "{call GetPerson{?,?}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,20);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                /*
                PersonId                index 1 INT
                FirstName               index 2 VARCHAR
                MiddleName              index 3 VARCHAR
                LastName                index 4 VARCHAR
                BirthDate               index 5 DATETIME
                SocialSecurityNumber    index 6 VARCHAR
                 */
                // notes: HYDRATING AN OBJECT
                Person person = new Person();
                person.setPersonId(rs.getInt(1));
                person.setFirstName(rs.getString(2));
                person.setMiddleName(rs.getString(3));
                person.setLastName(rs.getString(4));
                person.setBirthDate(rs.getDate(5));
                person.setSSN(rs.getString(6));

                personList.add(person);

            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return personList;    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(int personId) {
        return false;
    }
}
