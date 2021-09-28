package id.otosales.apps.dummy

import id.otosales.apps.dummy.product.Product

class Dummy {
    companion object {
        fun product(): ArrayList<Product> {
            val products = ArrayList<Product>()

            products.add(Product(1, "Toyota Avanza 2010 M/T", 120000000))
            products.add(Product(2, "Toyota Avanza 2012 M/T", 130000000))
            products.add(Product(3, "Honda Vario 150 2019", 24000000))
            products.add(Product(4, "Honda Vario 125 2015", 18000000))
            products.add(Product(5, "Honda Jazz A/T 2007", 98000000))
            products.add(Product(6, "Honda Jazz A/T 2009", 21000000))
            products.add(Product(7, "Daihatsu Grandmax M/T 2016", 16000000))
            products.add(Product(8, "Daihatsu Grandmax A/T 2016", 16500000))

            return products
        }

        fun province() : ArrayList<String>{
            val provinces = ArrayList<String>()

            provinces.add("Jawa Barat")
            provinces.add("Jawa Tengah")
            provinces.add("DKI Jakarta")

            return provinces
        }

        fun city() : ArrayList<String>{
            val cities = ArrayList<String>()

            cities.add("Jakarta Timur")
            cities.add("Jakarta Utara")
            cities.add("Blora")
            cities.add("Bandung")

            return cities
        }
    }
}