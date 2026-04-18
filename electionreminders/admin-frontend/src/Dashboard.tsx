import { Button, Table } from 'antd';
import { useEffect, useState } from 'react';
import type { ElectionSuggestion, ElectionSuggestionFromBackend } from './types';

function Dashboard() {
    const [data, setData] = useState<ElectionSuggestion[]>([]);

    useEffect(() => {
        async function loadData() {
            const response = await fetch('/electionSuggestions'),
                returnedBackendData = await response.json();

            console.log("data is", returnedBackendData);
            const mappedFrontEndData = returnedBackendData.map((backendData: ElectionSuggestionFromBackend) => {
                return {
                    id: backendData.electionSuggestionId,
                    electionName: backendData.electionName,
                    electionType: backendData.electionType,
                    electionArea: backendData.electionArea,
                    electionPollsOpenDateTime: backendData.electionPollsOpenDateTime,
                    electionPollsCloseDateTime: backendData.electionPollsCloseDateTime,
                    electionDetails: backendData.electionDetails
                }
            })
            setData(mappedFrontEndData);
        };

        loadData();
    }, []);

    async function deleteElectionSuggestions(ids: string[]) {
        const response = await fetch('/electionSuggestionsByIdsFromDashboard', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(ids),
        });

        if (!response.ok) {
            throw new Error('Failed to delete');
        }

        setData(prev =>
            prev.filter(item => !ids.includes(String(item.id)))
        );
    }

    async function approveElectionSuggestions(electionSuggestion: any) {
        const electionData = {
            electionName: electionSuggestion.electionName,
            countryName: electionSuggestion.electionArea,
            electionPollsOpenDateTime: electionSuggestion.electionPollsOpenDateTime,
            electionPollsCloseDateTime: electionSuggestion.electionPollsCloseDateTime,
            electionDetails: electionSuggestion.electionDetails
        },
            electionSuggestionIds = [electionSuggestion.id];


        const response = await fetch('/electionsFromDashboard', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify([electionData]),
        });

        if (!response.ok) {
            throw new Error('Failed to create');
        }

        setData(prev =>
            prev.filter(item => !electionSuggestionIds.includes(String(item.id)))
        );
    }

    const columns = [
        {
            title: 'ID',
            dataIndex: 'id',
            key: 'id',
            sorter: (a: ElectionSuggestion, b: ElectionSuggestion) => a.id - b.id
        },
        {
            title: 'Election Name',
            dataIndex: 'electionName',
            key: 'electionName'
        },
        {
            title: 'Election Type',
            dataIndex: 'electionType',
            key: 'electionType'
        },
        {
            title: 'Election Area',
            dataIndex: 'electionArea',
            key: 'electionArea'
        },
        {
            title: 'Election Polls Open Date Time',
            dataIndex: 'electionPollsOpenDateTime',
            key: 'electionPollsOpenDateTime'
        },
        {
            title: 'Election Polls Close Date Time',
            dataIndex: 'electionPollsCloseDateTime',
            key: 'electionPollsCloseDateTime'
        },
        {
            title: 'Election Details',
            dataIndex: 'electionDetails',
            key: 'electionDetails'
        },
        {
            key: 'action',
            render: (_: any, record: any) => (
                <Button onClick={() => approveElectionSuggestions(record)}>
                    Approve Suggestion
                </Button>
            )
        },
        {
            key: 'action',
            render: (_: any, record: any) => (
                <Button onClick={() => deleteElectionSuggestions([record.id])}>
                    Reject Suggestion
                </Button>
            )
        },


    ];

    // 👇 Ant Design expects a "key" field
    const dataSource = data.map(item => ({
        ...item,
        key: item.id
    }));

    return (
        <div style={{ padding: 20 }}>
            <h2>Election Suggestion Data</h2>

            <Table
                columns={columns}
                dataSource={dataSource}
                pagination={{ pageSize: 5 }}
            />
        </div>
    );
}

export default Dashboard;

