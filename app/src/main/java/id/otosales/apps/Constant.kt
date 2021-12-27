package id.otosales.apps

class Constant {
    class Mode {
        companion object {
            const val SIGN_UP = "SIGN_UP"
            const val SIGN_IN = "SIGN_IN"
        }
    }

    class Key {
        companion object{
            const val BUNDLING = "BUNDLING"
            const val PHONE = "PHONE"
            const val ARTICLE = "ARTICLE"
            const val MODE = "MODE"
            const val CATEGORY = "CATEGORY"
        }
    }

    class Value {
        companion object {
            const val CAR = "Mobil"
            const val BIKE = "Motor"
        }
    }

    class Name {
        companion object{
            const val DB = "otosales-database-room"
        }
    }

    class Url {
        companion object {
            const val BASE = "http://103.8.79.68:8080/"
            const val REGISTER = "${BASE}register"
            const val LOGIN = "${BASE}login"
            const val BANK = "${BASE}bank"
            const val PROVINCE = "${BASE}province"
            const val CITY = "${BASE}city"
            const val BRAND = "${BASE}brand"
            const val CATEGORY = "${BASE}category"
            const val PRODUCT = "${BASE}product"
            const val ARTICLE = "${BASE}article"
        }
    }
}