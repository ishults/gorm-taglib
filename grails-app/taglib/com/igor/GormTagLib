package com.igor

import org.codehaus.groovy.grails.validation.ConstrainedProperty

class GormTagLib {

    static namespace = 'gorm'

    /**
     * Returns the max length of a field for a given domain.
     * Prioritizes 'maxSize', then 'size'.  If neither is found, returns empty string.
     *
     * @attr clazz REQUIRED The full class name of the domain object being referenced
     * @attr field REQUIRED The property to look up the max length
     */
    def limit = { attrs ->
        String className = attrs.clazz
        String field = attrs.field

        if (!className || !field) {
            throwTagError("Tag [limit] is missing required attribute [clazz] and/or [field].")
        }

        Class clazz

        try {
            clazz = Class.forName(className, true, Thread.currentThread().getContextClassLoader())

        } catch (ClassNotFoundException e) {
            throwTagError("Tag [limit] could not find a class with name [$className]. Be sure to include the package name.")
        }

        if (!clazz.newInstance().hasProperty(field)) {
            throwTagError("Tag [limit] could not find field [$field] on class [$className].")
        }

        ConstrainedProperty fieldConstraint = clazz.constraints."$field"

        // The field exists but does not have any constraints, so return empty string
        if (!fieldConstraint) {
            out << ''

            return
        }

        out << (fieldConstraint.getAppliedConstraint('maxSize')?.maxSize ?:
            fieldConstraint.getAppliedConstraint('size')?.range?.to ?:
                '')
    }
}
