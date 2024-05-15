import { Avatar, Box, Td, Tr, Text, Badge } from "@chakra-ui/react"
import { competitor } from "../interfaces/competitor-interface"
; 
import { StarIcon } from "@chakra-ui/icons";
import Avatars from "./Avatars";
function Competitor({id, ranking, nome, provas, lumosity, keybr, media }: competitor) {
  return (
    <Tr key={id}>
        <Td textAlign='center' p={0}><Badge px={2}>{ranking}</Badge>{ranking  == 1 || ranking == 2 ? <StarIcon ml={2} color='goldenrod'/>: ''}</Td>
        <Td display='flex' alignItems='center'><Avatars nome={nome}/></Td>
        <Td textAlign='center' p={0}><Badge px={5}>{provas}</Badge></Td>
        <Td textAlign='center' p={0}><Badge px={5}>{lumosity}</Badge></Td>
        <Td textAlign='center' p={0}><Badge px={5}>{keybr}</Badge></Td>
        <Td textAlign='center' p={0}><Badge colorScheme='green' px={5}>{media}</Badge></Td>
    </Tr>
  )
}

export default Competitor