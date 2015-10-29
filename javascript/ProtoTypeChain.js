// JavaScriptの継承機構
// プロトタイプに継承したインスタンスを登録する

// スーパークラス的なオブジェクト
var Animal = function(){}

// プロトタイプオブジェクトに、オブジェクトリテラルでまとめてメンバを登録
Animal.prototype = {
   walk:function(){
      window.alert("トコトコ");
   }
};

var Hamster = function(){};
// プロトタイプオブジェクトに継承したオブジェクトを入れる
Hamster.prototype = new Animal();

// Hamsterオブジェクトだけのメソッドを追加する
Hamster.prototype.gnaw = function(){
   window.alert("がじがじ");
};

var ham = new Hamster();
ham.walk();
ham.gnaw();
