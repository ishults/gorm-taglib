package com.igor

import grails.validation.Validateable

@Validateable
class GormTagLibUser {
    String username
    String firstName
    String middleName
    String lastName
    Integer age

    static constraints = {
        username(maxSize: 50)
        firstName(size: 0..25)
        middleName()
        lastName(size: 0..20, maxSize: 30)
    }
}
