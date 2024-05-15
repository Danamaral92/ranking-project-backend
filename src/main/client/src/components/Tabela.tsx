import {
    Table,
    Thead,
    Tbody,
    Tfoot,
    Tr,
    Th,
    Td,
    TableCaption,
    TableContainer,
  } from '@chakra-ui/react'
import Competitor from './Competitor'
import { competitor } from '../interfaces/competitor-interface'

function Tabela({competitorList}: {competitorList: Array<competitor>} ) {
  return (
    <TableContainer >
            <Table variant='simple'>
                <TableCaption>#04 Mechatronics Ranking</TableCaption>
                <Thead>
                <Tr>
                    <Th>Pos</Th>
                    <Th>Nome</Th>
                    <Th isNumeric>Provas</Th>
                    <Th isNumeric>Lumosity</Th>
                    <Th isNumeric>Keybr</Th>
                    <Th isNumeric>Média</Th>
                </Tr>
                </Thead>
                <Tbody>
                    {competitorList.map((competitor: competitor)=> Competitor(competitor))}
                </Tbody>
            </Table>
        </TableContainer>
  )
}

export default Tabela

