db.createCollection("instituto", {
  validator: {
    $jsonSchema: {
      required: ["nome", "cnpj", "endereco"],
      properties: {
        nome: {
          bsonType: "string",
          maxLength: 64,
          description: "Nome da instituição.",
        },
        cnpj: {
          bsonType: "string",
          maxLength: 18,
          description: "CNPJ XX.XXX.XXX/0001-XX.",
        },
        endereco: {
          bsonType: "string",
          maxLength: 320,
          description: "Endereco da instituição.",
        },
        jovens: {
          bsonType: "array",
          description: "Lista de jovens.",
        },
        cursos: {
          bsonType: "array",
          description: "Lista de cursos.",
        },
      },
    },
  },
});
