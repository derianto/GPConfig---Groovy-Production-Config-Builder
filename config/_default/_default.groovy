// Any variable will be passed on to the next script
productName = "Groovy-production-config-builder"

// Convention: Only properties map is imported into application configuration.
// All variables outside of properties don't matter
properties += [

  "id": "root",

  "threadPool": [
    "maxConcurrent": 100,
    "maxCreationRate": 10
  ],

  // Test
  "testList": [1, 2, 4, 5, 6],
  "testNestedList": [[1, 2, 4, 5, 6], [7, 8, 9]],
  "testNestedMap": ["${productName}":
    [ "key": ["${productName}1", "${productName}2"]]
  ]
]

// Test recursive
properties += [
  "propertiesRecursive": properties
]
