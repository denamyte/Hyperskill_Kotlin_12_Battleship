data class Article(val name: String, val pages: Int, val author: String)

fun getArticleByName(articles: MutableList<Article>, name: String) =
    articles.firstOrNull { it.name == name }
