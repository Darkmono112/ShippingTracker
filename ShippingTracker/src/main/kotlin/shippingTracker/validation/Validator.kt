package shippingTracker.validation

interface Validator {
    fun validateInput(input:String):List<String>?
}