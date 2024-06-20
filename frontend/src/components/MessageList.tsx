import React from "react";

import { Party } from '@daml/types';
import { User } from '@daml.js/rentingPlatform';
import { Icon, List, ListItem } from 'semantic-ui-react'



type Props = {
  messages: User.Message[];
  partyToAlias: Map<Party, string>;
}


const MessageList: React.FC<Props> = ({messages, partyToAlias}) => (
  <List relaxed>
    {messages.map(message => {
      const { sender, receiver, text } = message;
      return (
        <ListItem
          className='test-select-message-item'
          key={message.text}>
          <strong>{partyToAlias.get(sender) ?? sender} &rarr; {partyToAlias.get(receiver) ?? receiver}:</strong> {text}
        </ListItem>
      );
    })}
  </List>
);






export default MessageList;
