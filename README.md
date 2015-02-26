# gorm-taglib
A taglib for reflecting on Grails Validateable objects and retrieving their constraints


### Usage
#### Limit 
Returns the `maxSize`, or `size` of a field, if either exists.  Otherwise returns an empty string.

`<gorm:limit clazz='package.className' field='fieldName'/>`

or

`gorm.limit(clazz: 'package.className', field: 'fieldName')`


See tests for examples: https://github.com/ishults/gorm-taglib/blob/master/test/unit/com/igor/GormTagLibSpec.groovy
