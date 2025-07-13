import React from 'react';
import { Address } from '../types';

interface AddressTableProps {
  addresses: Address[];
  onCreateAddress: () => void;
}

const AddressTable: React.FC<AddressTableProps> = ({ addresses, onCreateAddress }) => {
  return (
    <div className="table-section">
      <div className="table-header">
        <h3>Addresses</h3>
        <button className="create-button" onClick={onCreateAddress}>
          + Create Address
        </button>
      </div>
      <table className="data-table">
        <thead>
          <tr>
            <th>Type</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>Zip Code</th>
            <th>Country</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {addresses.length === 0 ? (
            <tr>
              <td colSpan={7} className="no-data">
                No addresses found. Click "Create Address" to add one.
              </td>
            </tr>
          ) : (
            addresses.map((address) => (
              <tr key={address.id}>
                <td>{address.type}</td>
                <td>{address.street}</td>
                <td>{address.city}</td>
                <td>{address.state}</td>
                <td>{address.zipCode}</td>
                <td>{address.country}</td>
                <td>
                  <button className="action-button">Edit</button>
                  <button className="action-button delete">Delete</button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};

export default AddressTable;