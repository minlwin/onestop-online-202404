import { Link } from "react-router";

export default function ShowDetails({to} : {to : string}) {
    return (
        <Link to={to} className="icon-link">
            <i className="bi-arrow-right"></i>
        </Link>
    )
}