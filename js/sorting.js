// sorting-examples.js
// Various JavaScript sorting examples in one file

console.log("===== 1. Default sort problem with numbers =====");

const nums = [100, 2, 30, 4, 25];
console.log("Original:", nums);

// WRONG for numbers (converts to strings)
console.log("Default sort:", [...nums].sort(), nums.sort()); // JS default sort treats elements as strings not numbers
// Output: [100, 2, 25, 30, 4]

console.log("\n===== 2. Sort numbers ascending =====");

const ascendingNums = [...nums].sort((a, b) => a - b);
console.log("Ascending:", ascendingNums);
// Output: [2, 4, 25, 30, 100]

console.log("\n===== 3. Sort numbers descending =====");

const descendingNums = [...nums].sort((a, b) => b - a);
console.log("Descending:", descendingNums);
// Output: [100, 30, 25, 4, 2]

console.log("\n===== 4. Sort decimals =====");

const prices = [19.99, 5.5, 10.01, 7.75, 3.14];

const sortedPrices = [...prices].sort((a, b) => a - b);
console.log("Sorted decimals:", sortedPrices);
// Output: [3.14, 5.5, 7.75, 10.01, 19.99]

console.log("\n===== 5. Sort array of objects by numeric key =====");

const employees = [
  { name: "John", salary: 75000 },
  { name: "Alice", salary: 95000 },
  { name: "Bob", salary: 60000 }
];

// ascending by salary
const salaryAsc = [...employees].sort((a, b) => a.salary - b.salary);
console.log("Salary ascending:", salaryAsc);

// descending by salary
const salaryDesc = [...employees].sort((a, b) => b.salary - a.salary);
console.log("Salary descending:", salaryDesc);

console.log("\n===== 6. Sort array of objects by ISO date =====");

const orders = [
  { id: 1, createdAt: "2024-11-10T10:30:00.000Z" },
  { id: 2, createdAt: "2023-05-02T08:15:00.000Z" },
  { id: 3, createdAt: "2025-01-20T18:45:00.000Z" }
];

// oldest first
const oldestFirst = [...orders].sort(
  (a, b) => new Date(a.createdAt) - new Date(b.createdAt)
);
console.log("Oldest first:", oldestFirst); // ------------------------------------------ // Oldest date has lowest milisiconds from epoch

// newest first
const newestFirst = [...orders].sort(
  (a, b) => new Date(b.createdAt) - new Date(a.createdAt)
);
console.log("Newest first:", newestFirst);

console.log("\n===== 7. Custom comparator: string length =====");

const words = ["banana", "kiwi", "strawberry", "fig", "apple"];

const byLength = [...words].sort((a, b) => a.length - b.length);
console.log("By shortest length:", byLength);

console.log("\n===== 8. Custom comparator: multiple fields =====");

const users = [
  { name: "Alice", age: 30 },
  { name: "Bob", age: 25 },
  { name: "Charlie", age: 25 },
  { name: "David", age: 35 }
];

// first sort by age, then by name alphabetically
const customSortedUsers = [...users].sort((a, b) => {
  if (a.age !== b.age) {
    return a.age - b.age;
  }

  return a.name.localeCompare(b.name); // ---------------------------------------------------------------------- // localecompare
});

console.log("Age then name:", customSortedUsers);

console.log("\n===== 9. Case-insensitive string sorting =====");

const names = ["john", "Alice", "bob", "charlie"];

const caseInsensitive = [...names].sort((a, b) =>
  a.localeCompare(b, undefined, { sensitivity: "base" })
);

console.log("Case insensitive:", caseInsensitive);

console.log("\n===== 10. Reusable comparator functions =====");

// reusable comparators
const sortAsc = key => (a, b) => a[key] - b[key];
const sortDesc = key => (a, b) => b[key] - a[key];

const products = [
  { item: "Laptop", price: 800 },
  { item: "Mouse", price: 20 },
  { item: "Monitor", price: 250 }
];

console.log("By price asc:", [...products].sort(sortAsc("price")));
console.log("By price desc:", [...products].sort(sortDesc("price")));
