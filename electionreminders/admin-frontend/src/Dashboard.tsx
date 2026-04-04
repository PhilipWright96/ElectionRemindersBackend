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
        }

        loadData();
    }, []);

    // 👇 Define columns
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
                <Button onClick={() => handleApproveClick(record)}>
                    Approve Suggestion
                </Button>
            )
        },
        {
            key: 'action',
            render: (_: any, record: any) => (
                <Button onClick={() => handleRejectClick(record)}>
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

function handleApproveClick(record: any): void {
    console.log(record);
    throw new Error('Function not implemented.');
}

function handleRejectClick(record: any): void {
    console.log(record);
    throw new Error('Function not implemented.');
}
