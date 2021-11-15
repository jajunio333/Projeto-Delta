import { HexBase64BinaryEncoding } from "crypto";

export type Aluno = {
    id: number,
    nome: string,
    endereço: string,
    foto: HexBase64BinaryEncoding
}