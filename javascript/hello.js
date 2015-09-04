(function(name){
  console.log(name+"　やっほ");
})("ぶるー")

function check(name){
  console.log(isNaN(name));
  console.log(encodeURIComponent(name));
  console.log(decodeURIComponent(name));
}
var func = check;
func("加賀さん");
check("ぶるー");
