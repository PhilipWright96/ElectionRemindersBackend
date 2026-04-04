export type ElectionSuggestionFromBackend = {
    electionSuggestionId: number;
    electionName: string;
    electionType: string;
    electionArea: string;
    electionPollsOpenDateTime: string;   // usually ISO string from backend
    electionPollsCloseDateTime: string;  // same here
    electionDetails: string;
};

export type ElectionSuggestion = {
    id: number;
    electionName: string;
    electionType: string;
    electionArea: string;
    electionPollsOpenDateTime: string;
    electionPollsCloseDateTime: string;
    electionDetails: string;
};