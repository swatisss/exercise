
window.onload = function(){
   timers = [];
   nums = [];
   stopCount = 0;

   runSlot(1);
   runSlot(2);
   runSlot(3);

   for(var i = 1; i <= 3; i++){
      document.getElementById('stop'+i).onclick = function(){
         console.log(i);
         stopSlot(i);
      };
   }

}

function runSlot(n){
   document.getElementById('num'+n).innerHTML = Math.floor(Math.random() * 10);
   timers[n] = setTimeout(function(){
      runSlot(n);
   }, 50);
}


function stopSlot(n){
   clearTimeout(timers[n]);
   console.log(n);
   nums[n] = document.getElementById('num'+n).innerHTML;
   stopCount++;

   if(stopCount == 3){

      checkSlot();
   }
}

function checkSlot(){
   alert("check");
}
