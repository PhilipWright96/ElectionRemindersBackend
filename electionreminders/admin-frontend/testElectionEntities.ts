import {
    ElectionEntity
} from "./src/types.ts";

export const mockElectionEntities: ElectionEntity[] = [
    {
        id: "12345",
        entityNames: ["Germany"],
        entityType: "COUNTRY",
        description: "A big ole country",
        newEntityName: ""
    },
    {
        id: "23456",
        entityNames: ["PARIS"],
        entityType: "CITY",
        description: "A nice city",
        newEntityName: ""
    },
];