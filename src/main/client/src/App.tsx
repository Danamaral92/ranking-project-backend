import { useEffect, useState } from 'react'
import './App.css'
import Tabela from './components/Tabela'
import { Card } from '@chakra-ui/react'
import { useApi } from './hooks/useApi'
import { competitor } from './interfaces/competitor-interface'

function App() {
  const [competitorList, setCompetitorList] = useState<Array<competitor>>([])
  const api = useApi();

  const getCompetitors = async () => {
    const data = await api.getCompetitors();
    
    if(data.length > 0){
      setCompetitorList(data)
    }
  }

  useEffect(() => {
    getCompetitors();
    
  }, []);

  return (
   <div className="app">
    <Card boxShadow='rgb(38, 57, 77) 0px 20px 30px -10px'>
    <Tabela competitorList={competitorList} />
    </Card>
   </div>
  )
}

export default App
