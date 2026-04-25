// ===== 1) Sort characters in a string =====

function sortString(str) {
  return str.split('').sort().join(''); // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - // STRINGS IN JS ARE IMMUTABLE
}

function sortStringCaseInsensitive(str) {
  return str
    .split('')
    .sort((a, b) => a.localeCompare(b, undefined, { sensitivity: 'base' }))
    .join('');
}

// ===== 2) Sort array of strings =====

function sortArrayLexicographic(arr) {
  return arr.sort(); // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - // mutates original array
}

function sortArrayLocale(arr) {
  return arr.sort((a, b) => a.localeCompare(b));
}

function sortArrayCaseInsensitive(arr) {
  return arr.sort((a, b) =>
    a.localeCompare(b, undefined, { sensitivity: 'base' })
  );
}

// ===== TESTING =====

console.log("---- String Sorting ----");
const str1 = "dcba";
console.log(sortString(str1)); // "abcd"

const str2 = "dCbA";
console.log(sortStringCaseInsensitive(str2)); // case-insensitive sort


console.log("\n---- Array Sorting ----");
const arr1 = ["banana", "apple", "cherry"];
console.log(sortArrayLexicographic([...arr1])); // ["apple", "banana", "cherry"]

const arr2 = ["Banana", "apple", "Cherry"];
console.log(sortArrayLocale([...arr2]));

console.log(sortArrayCaseInsensitive([...arr2]));