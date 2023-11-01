// var : function scope
var x = 10;
console.log(x);
var x = 20;
console.log(x);

// let : block scope

let y = 20;
{
  let y = 10;
  console.log(y);
}
console.log(y);

// const : constance (상수)
const z = 10;
// z = 20;
console.log(z);

const ssafy = {
  area: "서울",
  class: 10,
};
console.log(ssafy.area);
ssafy.area = "대전";
console.log(ssafy.area);

// ssafy = {};
