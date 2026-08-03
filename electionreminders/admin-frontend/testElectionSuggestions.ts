import {
    ElectionSuggestion
} from "./src/types.ts";

export const mockElectionSuggestions: ElectionSuggestion[] = [
    {
        id: 123567,
        electionName: "German Federal Election",
        countryName: "Germany",
        regionName: "",
        cityName: "",
        organizationName: "",
        electionType: "COUNTRY",
        electionSummary: "Mock election",
        electionDetails: "This is test data",
        electionPollsOpenDateTime: "2026-09-27T08:00:00",
        electionPollsCloseDateTime: "2026-09-27T18:00:00"
    },
    {
        id: 234567,
        electionName: "Paris Election",
        countryName: "France",
        regionName: "Paris",
        cityName: "Paris",
        organizationName: "",
        electionType: "CITY",
        electionSummary: "Mock election",
        electionDetails: "This is test data",
        electionPollsOpenDateTime: "2026-09-27T08:00:00",
        electionPollsCloseDateTime: "2026-09-27T18:00:00"
    },
    {
        id: 345678,
        electionName: "Halle Saale Election",
        countryName: "Germany",
        regionName: "Sachsen Anhalt",
        cityName: "",
        organizationName: "",
        electionType: "REGION",
        electionSummary: "Mock election",
        electionDetails: "This is test data",
        electionPollsOpenDateTime: "2026-09-27T08:00:00",
        electionPollsCloseDateTime: "2026-09-27T18:00:00"
    }
];