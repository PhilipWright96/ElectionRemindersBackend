import { Button, Table } from 'antd';
import { useEffect, useState } from 'react';

type ElectionSuggestion = {
    id: number;
    electionName: string;
    electionType: string;
    electionArea: string;
    electionPollsOpenDateTime: string;
    electionPollsCloseDateTime: string;
    electionDetails: string;
};

function Dashboard() {
    const [data, setData] = useState<ElectionSuggestion[]>([]);

    useEffect(() => {
        // temporary test data
        setData([
            { id: 1, electionName: 'Election Suggestion 1', electionType: 'country', electionArea: 'Germany', electionPollsOpenDateTime: '2026-03-29T14:23:45.123', electionPollsCloseDateTime: '2026-03-29T14:23:45.123', electionDetails: 'Here are some election details' },
            { id: 2, electionName: 'Election Suggestion 2', electionType: 'country', electionArea: 'Germany', electionPollsOpenDateTime: '2026-03-29T14:23:45.123', electionPollsCloseDateTime: '2026-03-29T14:23:45.123', electionDetails: 'Here are some election details' }
        ]);

        // later:
        // fetch('http://localhost:8080/api/data')
        //   .then(res => res.json())
        //   .then(setData);
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
