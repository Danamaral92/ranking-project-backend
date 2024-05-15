import { Avatar, Box, Text } from '@chakra-ui/react'
import img_debora from '../imgs/debora.jpeg'
import img_daniele from '../imgs/daniele.jpeg'
import img_gabriel from '../imgs/gabriel.jpeg'

const imagesList = [
    {
      id: 1,
      src: img_debora,
      nome: "Debora",
    },
    {
      id: 2,
      src: img_daniele,
      nome: "Daniele",
    },
    {
      id: 3,
      src: img_gabriel,
      nome: "Gabriel",
    },
  ];

function Avatars({nome}: {nome:string}) {
  return (
    <>
        <Avatar src={(imagesList.filter(e => e.nome == nome)).length > 0 ? (imagesList.filter(e => e.nome == nome))[0].src : '' } />
            <Box ml='3'>
                <Text fontWeight='bold' color='black'>{nome}</Text>
            </Box>
    </>
  )
}

export default Avatars