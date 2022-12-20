db.createCollection("jovem", {
  validator: {
    $jsonSchema: {
      required: ["nome", "dataNasc", "descricao", "apoiado"],
      properties: {
        nome: {
          bsonType: "string",
          maxLength: 64,
          description: "Nome do jovem.",
        },
        dataNasc: {
          bsonType: "string",
          maxLength: 10,
          description: "Data de nascimento do jovem.",
        },
        descricao: {
          bsonType: "string",
          maxLength: 320,
          description: "Descricao do jovem.",
        },
        apoiado: {
          bsonType: "boolean",
          description: "Jovem apoiado?",
        },
        apoiador: {
          bsonType: "object",
          description: "Apoiador do jovem.",
        },
        cursos: {
          bsonType: "array",
          description: "Lista de cursos do jovem.",
        },
      },
    },
  },
});
