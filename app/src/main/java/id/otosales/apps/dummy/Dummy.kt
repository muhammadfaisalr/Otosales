package id.otosales.apps.dummy

import id.otosales.apps.dummy.article.Article
import id.otosales.apps.dummy.product.Product
import id.otosales.apps.dummy.product.color.Color
import id.otosales.apps.dummy.type.Type

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

        fun color() : ArrayList<Color>{
            val colors = ArrayList<Color>()

            colors.add(Color(1, "Hitam", "#000000"))
            colors.add(Color(2, "Putih", "#FFFFFF"))
            colors.add(Color(3, "Merah", "#FF0000"))

            return colors
        }

        fun article() : ArrayList<Article>{
            val articles = ArrayList<Article>()

            articles.add(Article(1, "Artikel A", "Artikel A Adalah Sebagai Berikut", "Artikel A adalah sebagai berikut yang dimana saya sudah semuanya"))
            articles.add(Article(2, "Artikel B", "Artikel B Adalah Sebagai Berikut", "Artikel A adalah sebagai berikut yang dimana saya sudah semuanya"))
            articles.add(Article(3, "Artikel C", "Artikel C Adalah Sebagai Berikut", "Artikel A adalah sebagai berikut yang dimana saya sudah semuanya"))

            return articles
        }

        fun tenor() : ArrayList<String>{
            val tenors = ArrayList<String>()

            tenors.add("1")
            tenors.add("2")
            tenors.add("3")
            tenors.add("4")
            tenors.add("5")

            return tenors
        }

        fun type() : ArrayList<Type>{
            val types = ArrayList<Type>()

            types.add(Type("A/T Transmission", 198000000))
            types.add(Type("M/T Transmission", 199000000))

            return types
        }
    }
}