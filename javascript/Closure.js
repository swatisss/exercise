// Userオブジェクト
var User = function(id, name) {

    // private変数
    var userid;
    var username;

    // getterとsetter（public）
    // prototypeで宣言してもOK
    this.getUserId = function() {
        return userid;
    };
    this.getUserName = function() {
        return username;
    };
    this.setUserId = function(val) {
        userid = val;
    };
    this.setUserName = function(val) {
        username = val;
    };

    // constructor（初期値をセット）
    this.setUserId(id);
    this.setUserName(name);
};

// Userのインスタンス生成
var user1 = new User(1, "田中太郎");
console.log(user1.getUserId());
console.log(user1.getUserName());

var user2 = new User(2, "ぶるー");
user2.setUserName("加賀さん");
console.log(user2.getUserName());
console.log(User);
console.log(user1);
console.log(user2);

// // 下の2つはundefinedになる
// console.log(user1.userid);
// console.log(user1.username);
