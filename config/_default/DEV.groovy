properties += [

  "env": "DEV",
  "id": "${properties.id}.DEV",

  // To append to previous value rather than replace, make sure to use + operator
  "threadPool": properties.threadPool + [
    "maxConcurrent": 20
  ]
]
