import { Button, Input, Table } from 'antd';
import { useEffect, useState } from 'react';
import { config } from '../config.ts';
import { mockElectionEntities } from '../testElectionEntities.ts'
import type { ElectionEntity } from './types';

function ElectionEntityDashboard() {
    const [data, setData] = useState<ElectionEntity[]>([]);

    useEffect(() => {
        async function loadData() {
            var returnedBackendData;

            if (config.useMockData) {
                console.log("Returning mock entity data!");
                returnedBackendData = mockElectionEntities;
            }
            else {
                const response = await fetch('/electionEntities');
                returnedBackendData = await response.json();
            }


            console.log("data is", returnedBackendData);
            const mappedFrontEndData = returnedBackendData.map((backendData: ElectionEntityFromBackend) => {
                return {
                    id: backendData.id,
                    entityNames: backendData.entityNames,
                    entityType: backendData.entityType,
                    description: backendData.description,
                }
            })
            setData(mappedFrontEndData);
        };

        loadData();
    }, []);

    const columns = [
        {
            title: 'ID',
            dataIndex: 'id',
            key: 'id',
        },
        {
            title: 'Entity Names',
            dataIndex: 'entityNames',
            key: 'entityNames'
        },
        {
            title: 'Entity Type',
            dataIndex: 'entityType',
            key: 'entityType'
        },
        {
            title: 'Description',
            dataIndex: 'description',
            key: 'description'
        },
        {
            title: "New Entity Name",
            key: "newEntityName",
            render: (_: any, record: any) => (
                <Input
                    value={record.newEntityName}
                    onChange={(e) => {
                        setData(data =>
                            data.map(item =>
                                item.id === record.id
                                    ? { ...item, newEntityName: e.target.value }
                                    : item
                            )
                        );
                    }}
                />
            ),
        },
        {
            key: 'action',
            render: (_: any, record: any) => (
                <Button onClick={() => addNewEntityName(record)}>
                    Add New Entity Name
                </Button>
            )
        },

    ];

    async function addNewEntityName(newEntityRecord: any) {
        console.log("Adding new election name");
        console.log(newEntityRecord);

    }


    // 👇 Ant Design expects a "key" field
    const dataSource = data.map(item => ({
        ...item,
        key: item.id
    }));

    return (
        <div style={{ padding: 20 }}>
            <h2>Election Entity Data</h2>

            <Table
                columns={columns}
                dataSource={dataSource}
                pagination={{ pageSize: 5 }}
            />
        </div>
    );
}

export default ElectionEntityDashboard;

