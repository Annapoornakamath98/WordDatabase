package com.yml.worddb

class Words {
    var id:Int=0
    var userWord:String?=null
    constructor(id:Int,userWord: String){
        this.id=id
        this.userWord=userWord
    }
    constructor(userWord: String){
        this.userWord=userWord
    }


}