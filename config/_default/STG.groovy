properties += [

  "env": "STG",
  "id": "${properties.id}.STG",

  // To append to previous value rather than replace, make sure to use + operator
  "threadPool": properties.threadPool + [
    "maxConcurrent": 40
  ]
]
