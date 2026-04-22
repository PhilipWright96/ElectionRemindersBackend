export type ElectionSuggestionFromBackend = {
    electionSuggestionId: number;
    electionName: string;
    electionType: string;
    electionArea: string;
    countryName: string;
    regionName: string;
    cityName: string;
    organizationName: string;
    electionPollsOpenDateTime: string;   // usually ISO string from backend
    electionPollsCloseDateTime: string;  // same here
    electionDetails: string;
    electionSummary: string;
};

export type ElectionSuggestion = {
    id: number;
    electionName: string;
    electionType: string;
    countryName: string;
    regionName: string;
    cityName: string;
    organizationName: string;
    electionPollsOpenDateTime: string;
    electionPollsCloseDateTime: string;
    electionDetails: string;
    electionSummary: string;
};