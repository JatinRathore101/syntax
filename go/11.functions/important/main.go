package main

import (
	"errors"
	"fmt"
)

// Basic function: takes params and returns a single value
func add(a int, b int) int {
	return a + b
}

// Multiple return values: returns quotient and remainder
func divide(a int, b int) (int, int) {
	return a / b, a % b
}

// Value + error pattern: the standard Go error-handling idiom
func safeDivide(a int, b int) (int, error) {
	if b == 0 {
		return 0, errors.New("cannot divide by zero")
	}
	return a / b, nil
}

func main() {
	fmt.Println("===== 1 BASIC FUNCTION =====")
	sum := add(5, 3)
	fmt.Println("5 + 3 =", sum)

	fmt.Println("\n===== 2 MULTIPLE RETURN VALUES =====")
	q, r := divide(10, 3)
	fmt.Println("Quotient:", q)
	fmt.Println("Remainder:", r)

	fmt.Println("\n===== 3 VALUE + ERROR PATTERN =====")
	result, err := safeDivide(10, 2)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Println("Result:", result)

	fmt.Println("\nTrying division by zero...")
	_, err2 := safeDivide(10, 0)
	if err2 != nil {
		fmt.Println("Handled Error:", err2)
	}

	// Anonymous function: defined inline and stored in a variable
	fmt.Println("\n===== 4 ANONYMOUS FUNCTION =====")
	multiply := func(a int, b int) int {
		return a * b
	}
	fmt.Println("4 * 5 =", multiply(4, 5))
}
