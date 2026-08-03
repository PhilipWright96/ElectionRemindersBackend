import './App.css'
import Dashboard from './Dashboard'
import ElectionEntityDashboard from './ElectionEntityDashboard';

function App() {
  return (
    <div>
      <h1>Admin Front End for Election Reminders</h1>
      <Dashboard />
      <h1> Dashboard for Election Entities</h1>
      <ElectionEntityDashboard />
    </div>
  );
}

export default App
