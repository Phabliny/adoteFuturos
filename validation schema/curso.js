db.createCollection("curso", {
  validator: {
    $jsonSchema: {
      required: ["nome", "descricao", "cargaHoraria"],
      properties: {
        nome: {
          bsonType: "string",
          maxLength: 64,
          description: "Nome do curso.",
        },
        descricao: {
          bsonType: "string",
          maxLength: 320,
          description: "Descricao do curso.",
        },
        cargaHoraria: {
          bsonType: "string",
          maxLength: 4,
          description: "Carga horária do curso.",
        },
        instituicoes: {
          bsonType: "array",
          description: "Lista de instituicões.",
        },
      },
    },
  },
});
