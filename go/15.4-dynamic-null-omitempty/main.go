package main

import (
	"encoding/json"
	"fmt"
)

// Dynamic JSON, omitempty, and null handling with pointers
func main() {
	// Dynamic JSON: use map when structure is unknown
	raw := `{"name":"Jai","age":22,"active":true}`
	var data map[string]interface{}
	if err := json.Unmarshal([]byte(raw), &data); err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Println("Dynamic JSON:", data)
	fmt.Println("Name:", data["name"])

	// omitempty: skip zero-value fields in JSON output
	type Product struct {
		Name  string `json:"name"`
		Price int    `json:"price,omitempty"`
	}
	p := Product{Name: "Laptop"}
	pJSON, _ := json.Marshal(p)
	fmt.Println("omitempty:", string(pJSON))

	// Pointer field: distinguish null from missing/zero
	type Item struct {
		Name  string `json:"name"`
		Price *int   `json:"price"`
	}
	itemJSON := `{"name":"Phone","price":null}`
	var item Item
	if err := json.Unmarshal([]byte(itemJSON), &item); err != nil {
		fmt.Println("Error:", err)
		return
	}
	if item.Price == nil {
		fmt.Println("Price is NULL")
	}
}
