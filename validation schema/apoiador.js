db.createCollection("apoiador", {
  validator: {
    $jsonSchema: {
      required: ["nome", "cpf", "telefone"],
      properties: {
        nome: {
          bsonType: "string",
          maxLength: 64,
          description: "Nome do apoiador.",
        },
        cpf: {
          bsonType: "string",
          maxLength: 11,
          description: "CPF do apoiador.",
        },
        telefone: {
          bsonType: "string",
          maxLength: 11,
          description: "Telefone do apoiador.",
        },
        jovens: {
          bsonType: "array",
          description: "Lista de jovens.",
        },
      },
    },
  },
});
