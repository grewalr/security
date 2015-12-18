Meta:
@author grewalri

Scenario: A scenario in which the input data is masked using a hash digest with an encoder

Given that <digest> algorithm is chosen and encoder type <anEncoder>
When a <counterpartyId> is supplied
Then the output hash is <hash>

Examples:
tables/hashing_data.table