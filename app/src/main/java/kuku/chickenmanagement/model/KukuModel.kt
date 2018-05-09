package kuku.chickenmanagement.model

/**
 * Created by Fredy on 05/05/2018.
 */
class KukuModel() {

    var Title: String? = null
    var Content: String? = null
    var Pic: String? = null

    constructor(Title: String, Content:String) : this() {
        this.Title = Title
        this.Content = Content
    }
}