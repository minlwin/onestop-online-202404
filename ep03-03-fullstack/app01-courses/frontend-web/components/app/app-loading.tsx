import { Item, ItemMedia, ItemTitle } from "../ui/item";
import { Spinner } from "../ui/spinner";

export default function Loading({data} : {data : string}) {
    return (
        <Item>
            <ItemMedia>
                <Spinner />
            </ItemMedia>

            <ItemTitle>{`${data} is loading ...`}</ItemTitle>
        </Item>
    )
}