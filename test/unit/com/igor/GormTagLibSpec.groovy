package com.igor

import grails.test.mixin.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import spock.lang.Specification

@TestFor(GormTagLib)
class GormTagLibSpec extends Specification {
    void "limit() should throw an exception if attributes are missing or wrong"() {
        when:
            tagLib.limit(clazz: className, field: fieldName)

        then:
            thrown(GrailsTagException)

        where:
            className                    | fieldName
            null                         | 'username'
            GormTagLibUser.canonicalName | null
            'NoSuchClass'                | 'username'
            'GormTagLibUser'             | 'username' // Needs package name
            GormTagLibUser.canonicalName | 'NoSuchField'
    }

    void "limit() should return the max size of a field if it is present, or otherwise null"() {
        when:
            String value = tagLib.limit(clazz: GormTagLibUser.canonicalName, field: fieldName)

        then:
            expectedValue.toString() == value

        where:
            fieldName    | expectedValue
            'username'   | 50
            'firstName'  | 20
            'middleName' | ''
            'lastName'   | 30
            'age'        | ''
    }
}
