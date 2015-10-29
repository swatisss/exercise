// // JavaScriptにおける一番シンプルなクラス定義
// // var Animal = function(){};
// // 関数オブジェクトがクラスの役割を果たす
//
// // newしてみる
// // var animal = new Animal();
//
// // プロパティを追加
// var Animal = function(name,sex){
//    this.name = name;
//    this.sex = sex;
//    // this.toString = function(){
//    //    window.alert(animal.name+":"+animal.sex);
//    // }
// }
//
// // prototypeプロパティを使ってメソッドを使う
// // 追加したメソッドを使う
// Animal.prototype.toString = function(){
//       window.alert(this.name+":"+this.sex);
// };//prototypeに追加したときはセミコロンで閉じる
//
// var anim = new Animal("ぶるー","Man");
// anim.toString();

// prototypeで提供されるメンバは共有されるのか
var Animal = function(){};

Animal.prototype.name = "加賀さん";
var a1 = new Animal();
var a2 = new Animal();
window.alert(a1.name+":"+a2.name);

a1.name = "ぶるー";
window.alert(a1.name+":"+a2.name);
// ぶるー:加賀さん
// この場合、prototypeのnameを書き換えるのではなく、a1インスタンスに新たにnameプロパティを追加する
