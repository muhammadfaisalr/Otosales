package id.otosales.apps.dummy

import id.otosales.apps.dummy.product.Product

class Dummy {
    companion object {
        fun product(): ArrayList<Product> {
            val products = ArrayList<Product>()

            products.add(Product(1, "Toyota Avanza 2010 M/T", 120000000))
            products.add(Product(2, "Toyota Avanza 2012 M/T", 130000000))
            products.add(Product(3, "Honda Vario 150 2019", 24000000))
            products.add(Product(1, "Toyota Vario 125 2015", 18000000))

            return products
        }
    }
}